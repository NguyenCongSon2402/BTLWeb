
import dao.DAO;
import entity.Category;
import entity.Product;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) {
        DAO dao=new DAO();
    int count=dao.countProductCateID(1);
int id=1;
                List<Product> list= dao.pagingProductCateID(id,2);
for(Product o:list)
System.out.println(o);
        System.out.println(count);
    }
}
