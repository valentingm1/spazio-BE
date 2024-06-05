@Entity
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    private Long lugarId;

    //  Constructor
    public Favorito(Long id, User user, Long lugarId) {
        this.id = id;
        this.user = user;
        this.lugarId = lugarId;
    }
    // Getters y setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id;  }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Long getLugarId() { return lugarId; }

    public void setLugarId(Long lugarId) { this.lugarId = lugarId; }
}