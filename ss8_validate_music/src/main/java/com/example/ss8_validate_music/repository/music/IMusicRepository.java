package com.example.ss8_validate_music.repository.music;

import com.example.ss8_validate_music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMusicRepository extends JpaRepository<Music, Integer> {
    @Override
    Page<Music> findAll(Pageable pageable);

//    Page<Music> findByNameSongContaining(Pageable pageable,String name);
// @Query được sử dụng để chỉ định câu truy vấn SQL tùy chỉnh trong phương thức repository.
    @Query(value = "SELECT * FROM music where singer LIKE %:singer%  OR name_song LIKE %:nameSong%",nativeQuery = true)
//    Các tham số của phương thức (Pageable pageable, @Param("singer") String singer, @Param("nameSong") String nameSong)
//    được gắn kết với các tham số định danh trong câu truy vấn (:singer và :nameSong) thông qua Annotation @Param.
    Page<Music> searchSingerAndSong(Pageable pageable, @Param("singer") String singer , @Param("nameSong") String nameSong);
    @Query(value = "SELECT * FROM music where id_type = :idType",nativeQuery = true)
    Page<Music> searchForeignKeyOfMusic(Pageable pageable,@Param("idType") int idType);
    @Query(value = "select music.* from type join music on type.id_type = music.id_type where type.id_type = 2;" ,nativeQuery = true)
    Page<Music> listType2(Pageable pageable);
}
