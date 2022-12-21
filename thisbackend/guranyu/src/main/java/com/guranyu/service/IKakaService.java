package com.guranyu.service;

import java.util.List;

import com.guranyu.model.KartuKeluarga;

public interface IKakaService {
	public KartuKeluarga insertKaka(KartuKeluarga kaka);
	public List<KartuKeluarga> getAll();
	public KartuKeluarga updateKaka(int id, KartuKeluarga kaka);
	public KartuKeluarga deleteKaka(int id);
	public KartuKeluarga getById(int id);
}
