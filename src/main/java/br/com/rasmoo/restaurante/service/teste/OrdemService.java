package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CilenteDao;
import br.com.rasmoo.restaurante.dao.OrdemDao;
import br.com.rasmoo.restaurante.entity.Cliente;
import br.com.rasmoo.restaurante.entity.Endereco;
import br.com.rasmoo.restaurante.entity.Ordem;
import br.com.rasmoo.restaurante.entity.OrdensCardapio;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        CilenteDao cilenteDao = new CilenteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Endereco endereco = new Endereco("87112500", "Avenida João Fragal", "apartamente 304", "Sarandi", "Paraná");
        Cliente fernando = new Cliente("009.009.929-05", "Fernndo", "87.090-500");
        fernando.addEndereco(endereco);
        Ordem ordem = new Ordem(fernando);
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(1),2));
        cilenteDao.cadastrar(fernando);
        ordemDao.cadastrar(ordem);
        System.out.println(ordem);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
