package fun.hardware.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import fun.hardware.mapper.ProductMapper;
import fun.sprider.entity.Product;

@Controller
public class PageController {
	@Autowired
	private ProductMapper mapper;
	@RequestMapping({"index","/"})
	public String index(Model model) {
		mapper.getAllProduct();
		model.addAttribute("p", mapper.getAllProduct());
		return "index";
	}
	@RequestMapping("detail/{productId}")
	public String index(@PathVariable String productId,Model model) {
		Product p =mapper.getProductByID(productId);
		model.addAttribute("p", p);
		model.addAttribute("summary", new Gson().fromJson(p.getProductSummary(), Map.class));
		return "detail";
	}
}
