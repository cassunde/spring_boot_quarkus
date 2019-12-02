package br.com.cassunde.cep.repository;

import br.com.cassunde.cep.model.CepResponse;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends PagingAndSortingRepository<CepResponse, String> {}
