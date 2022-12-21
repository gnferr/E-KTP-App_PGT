package com.guranyu.repository;

import java.util.List;

import com.guranyu.model.KartuKeluarga;

public interface IKakaRepository {
	public KartuKeluarga insertKaka(KartuKeluarga kaka);
	public List<KartuKeluarga> getAll();
	public KartuKeluarga updateKaka(int id,KartuKeluarga kaka);
	public KartuKeluarga deleteKaka(int id);
	public KartuKeluarga getById(int id);
}
