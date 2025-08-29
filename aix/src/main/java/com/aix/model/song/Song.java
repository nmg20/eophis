package com.aix.model.song;

import com.aix.model.playlist.Playlist;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "song")
public class Song {

	private Long id;
	
	private String name;
	private Long artistId;
	private Long albumId;
	private String path;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "playlist_id")
	private Playlist playlist;
}
