package com.aix.model.song;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "audio_features")
public class AudioFeatures {

	private Long id;
	
	@OneToOne
	@JoinColumn(name = "song_id", unique = true)
	private Song song;
	
	private Integer bpm;
	private String key;
	private LocalDateTime analyzedDate;
	
	public AudioFeatures() {
		
	}
	
	public AudioFeatures(Song song, Integer bpm, String key, LocalDateTime analyzedDate) {
		this.song = song;
		this.bpm = bpm;
		this.key = key;
		this.analyzedDate = analyzedDate;
	}
}
