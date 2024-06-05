import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    List<Favorito> findByUserIdAndItemId(Long usuarioId, Long lugarId);
}