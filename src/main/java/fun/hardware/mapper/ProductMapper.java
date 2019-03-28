package fun.hardware.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import fun.sprider.entity.Product;

@Mapper
public interface ProductMapper {
	@Select("select * from product limit 12")
	public List<Product> getAllProduct();
	
	@Select("select * from product where productId = #{param1} ")
	public Product getProductByID(String productID);
}
