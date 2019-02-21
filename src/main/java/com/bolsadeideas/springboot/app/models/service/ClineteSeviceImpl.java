package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Service
public class ClineteSeviceImpl implements IClienteService {

	@Autowired
	private IClienteDao clientedao;

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {

		return (List<Cliente>) clientedao.findAll();
	}
	
	

	@Override
	@Transactional(readOnly=true)
	public Cliente findOne(Long id) {

		return clientedao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void save(Cliente cliente) {
		clientedao.save(cliente);

	}


	@Override
	@Transactional
	public void delete(Long id) {

		clientedao.deleteById(id);

	}



	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		
		return clientedao.findAll(pageable);
	}

}
