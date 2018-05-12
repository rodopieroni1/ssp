/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luism
 */
@Stateless
public class FortalezasDebilidadesFacade extends AbstractFacade<FortalezasDebilidades> {
    @PersistenceContext(unitName = "sspPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FortalezasDebilidadesFacade() {
        super(FortalezasDebilidades.class);
    }
    
}
