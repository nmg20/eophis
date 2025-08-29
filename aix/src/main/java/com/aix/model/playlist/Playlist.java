package com.aix.model.playlist;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.aix.model.song.Song;;

@Entity
@Table(name = "playlist")
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private String path;
	private PlaylistSource source;
	private Long authorId;
	private LocalDateTime created;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public PlaylistSource getSource() {
		return source;
	}

	public void setSource(PlaylistSource source) {
		this.source = source;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Song> songs;
	
	public Playlist() {
		
	}
	
	public Playlist(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.description = builder.description;
		this.path = builder.path;
		this.source = builder.source;
		this.authorId = builder.authorId;
		this.songs = builder.songs;
	}
	
	public static class Builder {
		private Long id;
		private String name;
		private String description;
		private String path;
		private PlaylistSource source;
		private Long authorId;
		private List<Song> songs;
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		
		public Builder path(String path) {
			this.path = path;
			return this;
		}
		
		public Builder source(PlaylistSource source) {
			this.source = source;
			return this;
		}
		
		public Builder authorId(Long authorId) {
			this.authorId = authorId;
			return this;
		}
		
		public Builder songs(List<Song> songs) {
			this.songs = songs;
			return this;
		}
		
	}
	
}
