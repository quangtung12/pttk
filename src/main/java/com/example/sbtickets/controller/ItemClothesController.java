import com.example.sbtickets.bean.ItemClothesBean;
import com.example.sbtickets.bean.WrapperResponse;
import com.example.sbtickets.common.UrlConst;
import com.example.sbtickets.entity.ItemClothes;
import com.example.sbtickets.service.ItemClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemCLothesController {

    @Autowired
    ItemClothesService itemClothesService;
    @RequestMapping(value = UrlConst.GET_ITEM_CLOTHES, method = RequestMethod.GET)

    public ResponseEntity<WrapperResponse> getItemClothes() {
        WrapperResponse response = new WrapperResponse();
        List<ItemClothes> result = new ArrayList<>();
        try {
            result = itemClothesService.getItemClothes();
            response.setBody(result);
            response.setStatus(HttpStatus.OK.value());
        }
        catch (Exception ex){
            response.setMsg("Not found");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.GET_ITEM_CLOTHES_ID, method = RequestMethod.GET)

    public ResponseEntity<WrapperResponse> getItemClothesId(@PathVariable("id") Integer id){
        WrapperResponse response = new WrapperResponse();
        ItemClothes itemClothes;
        try {
            itemClothes = itemClothesService.getItemClothesId(id);
            response.setBody(itemClothes);
            response.setStatus(HttpStatus.OK.value());
        } catch (Exception ex){
            response.setMsg("Cannot find driver");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.CREATE_ITEM_CLOTHES, method = RequestMethod.POST)

    public ResponseEntity<WrapperResponse> createItemClothes(@RequestBody ItemClothesBean itemClothes) {
        WrapperResponse response = new WrapperResponse();
        ItemClothes newItemCLothes, createdItemClothes;
        try{
            newItemCLothes = new ItemClothes(
                    itemClothes.getId(),
                    itemClothes.getCartId(),
                    itemClothes.getBar_code(),
                    itemClothes.setDiscount_code(),
                    itemClothes.getPrice(),
                    itemClothes.getClothesId()
            );
            response.setBody(createdItemClothes);
            response.setStatus(HttpStatus.OK.value());
            response.setMsg("Add item clothes successfully");
        }catch (Exception e) {
            response.setMsg("Cannot add new item clothes");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.UPDATE_ITEM_CLOTHES, method = RequestMethod.PUT)

    public ResponseEntity<WrapperResponse> updateItemClothes(@PathVariable("id") Integer id, @RequestBody ItemClothesBean itemClothes) {
        WrapperResponse response = new WrapperResponse();
        ItemClothes updatingItemClothes;
        try{
            updatingItemClothes = new ItemClothes(
                    itemClothes.getId(),
                    itemClothes.getCartId(),
                    itemClothes.getBar_code(),
                    itemClothes.setDiscount_code(),
                    itemClothes.getPrice(),
                    itemClothes.getClothesId()
            );
            response.setMsg("Updated successfully");
            response.setStatus(HttpStatus.OK.value());
        } catch (Exception ex){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMsg("Updated fail");
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConst.DELETE_ITEM_CLOTHES, method = RequestMethod.DELETE)

    public ResponseEntity<WrapperResponse> deleteItemClothes(@PathVariable("id") Integer id) {
        WrapperResponse response = new WrapperResponse();
        try{
            itemClothesService.deleteItemClothes(id);
            response.setStatus(HttpStatus.OK.value());
            response.setMsg("Deleted successfully");
        } catch (Exception ex){
            response.setMsg(ex.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<WrapperResponse>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        return new ResponseEntity<WrapperResponse>(response, HttpStatus.OK);
    }


}