package by.entity;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="order_type_id", nullable=false)
    private OrderType orderType;

    // getters and setters

}
