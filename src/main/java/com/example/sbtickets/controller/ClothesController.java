package com.example.sbtickets.controller;

import com.example.sbtickets.bean.ClothesBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.Clothes;
import com.example.sbtickets.entity.ClothesBrands;
import com.example.sbtickets.entity.StyleClothes;
import com.example.sbtickets.service.ClothesBrandsImplement;
import com.example.sbtickets.service.ClothesImplement;
import com.example.sbtickets.service.StyleClothesImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClothesController {
    @Autowired
    ClothesImplement clothesImplement;
    @Autowired
    StyleClothesImplement styleClothesImplement;
    @Autowired
    ClothesBrandsImplement clothesBrandsImplement;

    @RequestMapping(value = UrlConst.GET_CLOTHES, method = RequestMethod.GET)
    public ResponseEntity<WrapperResponse> getClothes() {
        WrapperResponse response = new WrapperResponse();
        List<Clothes> result = new ArrayList<>();
        try {
            result = clothesImplement.getClothes();
            response.setBody(result);
            response.setStatus(HttpStatus.OK.value());
        } catch (Exception ex) {
            response.setMsg("Not found");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }
    @RequestMapping(value = UrlConst.CREATE_CLOTHES, method = RequestMethod.POST)
    public ResponseEntity<WrapperResponse> createClothes(HttpServletRequest request, @RequestBody ClothesBean clothes){
        Clothes newClothes, createdClothes;
        WrapperResponse response = new WrapperResponse();
        try{
            int styleID = clothes.getStyleID();
            int brandsID = clothes.getBrandsID();
            ClothesBrands brands = clothesBrandsImplement.getBrandById(brandsID);
            StyleClothes style = styleClothesImplement.getStyleById(styleID);
            if (style != null && brands != null) {
                newClothes = new Clothes(
                        clothes.getId(),
                        style,
                        brands,
                        clothes.getName(),
                        clothes.getManufacture(),
                        clothes.getSize(),
                        clothes.getMaterial(),
                        clothes.getColor(),
                        clothes.getImage()
                );
                createdClothes = clothesImplement.createClothes(newClothes);
                response.setBody(newClothes);
                response.setStatus(HttpStatus.OK.value());
                response.setMsg("create new clothes successfully");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            response.setMsg("cannot create!!!");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response,HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response,HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.GET_CLOTHES_BY_ID, method = RequestMethod.GET)
    public ResponseEntity<WrapperResponse> getClothesById(@PathVariable("id") Integer id){
        WrapperResponse response = new WrapperResponse();
        Clothes clothes;
        try{
            clothes = clothesImplement.getClothesById(id);
            if(clothes == null){
                response.setMsg("Can't not find clothes with id=" + id);
                response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
                return new ResponseEntity<WrapperResponse>(response, HttpStatus.EXPECTATION_FAILED);
            }
            response.setBody(clothes);
            response.setStatus(HttpStatus.OK.value());
        }catch (Exception ex){
            response.setMsg("cannot find clothes");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.UPDATE_CLOTHES,method = RequestMethod.PUT)
    public ResponseEntity<WrapperResponse> updateClothes(@PathVariable("id") Integer id, @RequestBody ClothesBean clothes) {
        WrapperResponse response = new WrapperResponse();
        Clothes upClothes;
        int styleID = clothes.getStyleID();
        int brandsID = clothes.getBrandsID();
        StyleClothes style = styleClothesImplement.getStyleById(styleID);
        ClothesBrands brands = clothesBrandsImplement.getBrandById(brandsID);
        try{
            upClothes = new Clothes(
                    clothes.getId(),
                    style,
                    brands,
                    clothes.getName(),
                    clothes.getManufacture(),
                    clothes.getSize(),
                    clothes.getMaterial(),
                    clothes.getColor(),
                    clothes.getImage()
            );
            clothesImplement.updateClothes(upClothes);
            response.setStatus(HttpStatus.OK.value());
            response.setMsg("Update Successfully");
        }catch(Exception ex){
            response.setMsg("Cannot Update!!!");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.DELETE_CLOTHES, method = RequestMethod.DELETE)
    public ResponseEntity<WrapperResponse> deleteClothes (@PathVariable("id") Integer id){
            WrapperResponse response = new WrapperResponse();
            try{
                clothesImplement.deleteClothes(id);
                response.setStatus(HttpStatus.OK.value());
                response.setMsg("Delete Clothes Successfully!!!");
            }catch(Exception ex){
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                response.setMsg("Fail");
                return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
            }
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.DELETE_CLOTHES_S, method = RequestMethod.POST)
    public ResponseEntity<WrapperResponse> deleteClothesS(@RequestBody Integer[] ids){
        WrapperResponse response = new WrapperResponse();
        try{
            List<Integer> list = Arrays.asList(ids);
            clothesImplement.deleteClothesS(list);
            response.setStatus(HttpStatus.OK.value());
            response.setMsg("Deleted successfully");
        } catch (Exception ex){
            //ex.getMessage()
            response.setMsg("fail");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

/*
    @RequestMapping(value = UrlConst.FIND_CLOTHES, method = RequestMethod.GET)
    public ResponseEntity<WrapperResponse> findClothes(@RequestBody String name ){
        WrapperResponse response = new WrapperResponse();
        Clothes clothes;
        try{
            clothes = clothesImplement.findClothes(name);

        }*/
}
