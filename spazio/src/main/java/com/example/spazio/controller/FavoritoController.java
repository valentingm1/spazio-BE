import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {
    @Autowired
    private FavoritoRepository favoritoRepository;

    @PostMapping
    public ResponseEntity<Favorito> addFavorito(@RequestBody Favorito favorito) {
        // Revisa si favorito existe
        List<Favorito> existingFavoritos = favoritoRepository.findByUsuarioIdAndLugarId(
                favorito.getUsuario().getId(), favorito.getLugarId());

        if (existingFavoritos.isEmpty()) {
            // agrega nuevo favorito
            return ResponseEntity.ok(favoritoRepository.save(favorito));
        } else {
            // regresa favoritos existentes
            return ResponseEntity.ok(existingFavoritos.get(0));
        }
    }

    @DeleteMapping("/{usuarioId}/{lugarId}")
    public ResponseEntity<Void> removeFavorito(@PathVariable Long usuarioId, @PathVariable Long lugarId) {
        List<Favorito> favoritos = favoritoRepository.findByUsuarioIdAndLugarId(usuarioId, lugarId);

        if (!favoritos.isEmpty()) {
            favoritoRepository.delete(favoritos.get(0));
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Favorito>> getFavoritosByUsuario(@PathVariable Long usuarioId) {
        List<Favorito> favoritos = favoritoRepository.findByUsuarioId(usuarioId);
        return ResponseEntity.ok(favoritos);
    }
}