package com.guranyu.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.guranyu.model.AnggotaKeluarga;
import com.guranyu.repository.IWargaRepository;

@Repository
public class WargaRepository implements IWargaRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public AnggotaKeluarga insertWarga(AnggotaKeluarga warga) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_anggota_keluarga(agama,id_kk,jenis_kelamin,kepala_keluarga,nama,nik,pendidikan,"
				+ "tanggal_lahir,tempat_lahir) VALUES(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query , new Object[] {warga.getAgama(),warga.getId_kk(),warga.getJenis_kelamin(),warga.getKepala_keluarga(),
				warga.getNama(),warga.getNik(),warga.getPendidikan(),warga.getTanggal_lahir(),warga.getTempat_lahir()});
		return warga;
	}

	@Override
	public List<AnggotaKeluarga> getWarga() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class));
	}

	@Override
	public AnggotaKeluarga updateWarga(AnggotaKeluarga warga, int id) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_anggota_keluarga SET agama = ? , id_kk = ?, jenis_kelamin = ? , kepala_keluarga = ? ,"
				+ "nama = ? , nik = ?, pendidikan = ? , tanggal_lahir = ? , tempat_lahir = ? WHERE id = ? ";
		jdbcTemplate.update(query, new Object[] {warga.getAgama(),warga.getId_kk(),warga.getJenis_kelamin(),warga.getKepala_keluarga(),warga.getNama(),
				warga.getNik(),warga.getPendidikan(),warga.getTanggal_lahir(),warga.getTempat_lahir(),id});
		return warga;
	}

	@Override
	public AnggotaKeluarga deleteWarga(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class),id);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id = ?";
		jdbcTemplate.update(query , id);
		return result;
	}

	@Override
	public List<AnggotaKeluarga> getById(String id_kk) {
		// TODO Auto-generated method stub
		String query = ("SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?");
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class),id_kk);
	}

	@Override
	public AnggotaKeluarga getIdWarga(int id) {
		// TODO Auto-generated method stub
		String query = ("SELECT * FROM tb_anggota_keluarga WHERE id = ?");
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class),id);
	}

	@Override
	public List<AnggotaKeluarga> deleteByKaka(String id_kk) {
		// TODO Auto-generated method stub
		String query = ("SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?");
		var result = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(AnggotaKeluarga.class),id_kk);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id_kk = ?";
		jdbcTemplate.update(query, id_kk);
		return result;
	}

}
