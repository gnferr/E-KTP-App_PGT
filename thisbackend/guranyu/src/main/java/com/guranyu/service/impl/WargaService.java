package com.guranyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guranyu.model.AnggotaKeluarga;
import com.guranyu.repository.IWargaRepository;
import com.guranyu.service.IWargaService;

@Service
public class WargaService implements IWargaService {

	@Autowired
	IWargaRepository wargaRepository;
	
	@Override
	public AnggotaKeluarga insertWarga(AnggotaKeluarga warga) {
		// TODO Auto-generated method stub
		return wargaRepository.insertWarga(warga);
	}

	@Override
	public List<AnggotaKeluarga> getWarga() {
		// TODO Auto-generated method stub
		return wargaRepository.getWarga();
	}

	@Override
	public AnggotaKeluarga updateWarga(AnggotaKeluarga warga, int id) {
		// TODO Auto-generated method stub
		return wargaRepository.updateWarga(warga, id);
	}

	@Override
	public AnggotaKeluarga deleteWarga(int id) {
		// TODO Auto-generated method stub
		return wargaRepository.deleteWarga(id);
	}

	@Override
	public List<AnggotaKeluarga> getById(String id_kk) {
		// TODO Auto-generated method stub
		return wargaRepository.getById(id_kk);
	}

	@Override
	public AnggotaKeluarga getIdWarga(int id) {
		// TODO Auto-generated method stub
		return wargaRepository.getIdWarga(id);
	}

	@Override
	public List<AnggotaKeluarga> deleteByKaka(String id_kk) {
		// TODO Auto-generated method stub
		return wargaRepository.deleteByKaka(id_kk);
	}

}
