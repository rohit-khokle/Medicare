/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprises;

//import Business.Role.Role;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class InsuranceEnterprise extends Enterprise {
    
    public InsuranceEnterprise(String name){
        super(name, EnterpriseType.Insurance);
    }
/*   @Override
   public ArrayList<Role> getSupportedRole() {
        return null;
    }
*/
   public Role getSupportedRole() {
        return null;
    }
}
