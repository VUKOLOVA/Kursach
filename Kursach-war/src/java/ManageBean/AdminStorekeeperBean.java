
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;


import com.dao.AdminInt;
import com.model.Worker;
import java.io.Serializable;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author НР
 */
@Named(value="adminStorekeeperBean")
@RequestScoped
public class AdminStorekeeperBean implements Serializable{
@EJB
    private AdminInt adm;

    /**
     * Creates a new instance of AdminStorekeeperBean
     */
    public AdminStorekeeperBean() {
        w = new Worker();
    }
    private Worker w;

    public Worker getW() {
        return w;
   }

    public void setW(Worker w) {
        this.w = w;
    }
    private int id_worker;

    public int getId_worker() {
        return id_worker;
    }

    public void setId_worker(int id_worker) {
        this.id_worker = id_worker;
    }

    public String insertStorekeeper() throws SQLException {
        adm.createStorekeeper(w);
            return "/AdminSelectStorekeeper.xhtml";
       
    }

    public String viewSelectWorker(int id_worker) {
        this.id_worker = id_worker;
        return "/AdminEditStorekeeper.xhtml";
    }

    public Worker selectStorekeeper(int id_material) {
        return adm.selectWorker(id_material);
    }

    public String updateStorekeeper() throws SQLException {

        adm.updateWorker(w);
            return "/AdminSelectStorekeeper";
        
    }

    public String deleteStorekeeper(int id_worker) {
        adm.deleteStorekeeper(id_worker);
            return "/AdminSelectStorekeeper.xhtml";
        
    }

}
