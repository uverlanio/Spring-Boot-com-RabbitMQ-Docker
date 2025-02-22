package io.github.cursodsousa.mscartoes.infra.repository;

import io.github.cursodsousa.mscartoes.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {

    List<ClienteCartao> findByCpf(String Cpf);
}
