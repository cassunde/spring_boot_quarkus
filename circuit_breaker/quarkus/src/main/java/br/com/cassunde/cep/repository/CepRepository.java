package br.com.cassunde.cep.repository;

import br.com.cassunde.cep.model.CepResponse;
import com.mongodb.MongoWriteException;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;

import javax.enterprise.context.Dependent;

@Dependent
public class CepRepository implements PanacheMongoRepositoryBase<CepResponse, String> {

    @Override
    public void persist(CepResponse cepResponse) {
        try {
            cepResponse.persist();
        }catch (MongoWriteException e){

            e.printStackTrace();
        }
    }
}
