package com.guranyu.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.guranyu.model.KartuKeluarga;
import com.guranyu.repository.IKakaRepository;

@Repository
public class KakaRepository implements IKakaRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public KartuKeluarga insertKaka(KartuKeluarga kaka) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_kartu_keluarga(alamat,desa_kelurahan,kabupaten_kota,kecamatan,"
				+ "kode_pos,nomor_kk,provinsi,rt,rw) VALUES(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query , new Object[] {kaka.getAlamat(),kaka.getDesa_kelurahan(),kaka.getKabupaten_kota(),kaka.getKecamatan(),
				kaka.getKode_pos(),kaka.getNomor_kk(),kaka.getProvinsi(),kaka.getRt(),kaka.getRw()});
		return kaka;
	}

	@Override
	public List<KartuKeluarga> getAll() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(KartuKeluarga.class));
	}

	@Override
	public KartuKeluarga updateKaka(int id, KartuKeluarga kaka) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_kartu_keluarga SET alamat = ? , desa_kelurahan = ? , kabupaten_kota = ? , kecamatan = ? ,"
				+ "kode_pos = ? , nomor_kk = ? , provinsi = ? , rt = ? , rw = ? WHERE id = ?";
		jdbcTemplate.update(query , new Object[] {kaka.getAlamat(),kaka.getDesa_kelurahan(),kaka.getKabupaten_kota(),kaka.getKecamatan(),
				kaka.getKode_pos(),kaka.getNomor_kk(),kaka.getProvinsi(),kaka.getRt(),kaka.getRw(),id});
		return kaka;
	}

	@Override
	public KartuKeluarga deleteKaka(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(KartuKeluarga.class),id);
		
		query = "DELETE FROM tb_kartu_keluarga WHERE id = ?";
		jdbcTemplate.update(query,id);
		return result;
	}

	@Override
	public KartuKeluarga getById(int id) {
		// TODO Auto-generated method stub
		String query = ("SELECT * FROM tb_kartu_keluarga WHERE id = ?");
		return jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<>(KartuKeluarga.class),id);
	}

}
