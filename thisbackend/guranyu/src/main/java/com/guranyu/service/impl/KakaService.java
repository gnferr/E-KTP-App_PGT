package com.guranyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guranyu.model.KartuKeluarga;
import com.guranyu.repository.IKakaRepository;
import com.guranyu.service.IKakaService;

@Service
public class KakaService implements IKakaService{

	@Autowired
	IKakaRepository kakaRepository;

	@Override
	public KartuKeluarga insertKaka(KartuKeluarga kaka) {
		// TODO Auto-generated method stub
		return kakaRepository.insertKaka(kaka);
	}

	@Override
	public List<KartuKeluarga> getAll() {
		// TODO Auto-generated method stub
		return kakaRepository.getAll();
	}

	@Override
	public KartuKeluarga updateKaka(int id, KartuKeluarga kaka) {
		// TODO Auto-generated method stub
		return kakaRepository.updateKaka(id, kaka);
	}

	@Override
	public KartuKeluarga deleteKaka(int id) {
		// TODO Auto-generated method stub
		return kakaRepository.deleteKaka(id);
	}

	@Override
	public KartuKeluarga getById(int id) {
		// TODO Auto-generated method stub
		return kakaRepository.getById(id);
	}
	

}
