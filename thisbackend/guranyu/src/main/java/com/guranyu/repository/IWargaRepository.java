package com.guranyu.repository;

import java.util.List;

import com.guranyu.model.AnggotaKeluarga;

public interface IWargaRepository {
	public AnggotaKeluarga insertWarga(AnggotaKeluarga warga);
	public List<AnggotaKeluarga> getWarga();
	public AnggotaKeluarga updateWarga(AnggotaKeluarga warga , int id);
	public AnggotaKeluarga deleteWarga(int id);
	public List<AnggotaKeluarga> getById(String id_kk);
	public AnggotaKeluarga getIdWarga(int id);
	public List<AnggotaKeluarga> deleteByKaka(String id_kk);
}
