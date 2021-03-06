package fr.poulet4j.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Une cellule du labyrinth.
 */
public class Cell implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id de la cellule (ça sert à rien)
     * @deprecated utiliser le equals : les id ne sont pas toujours identique
     */
    @Deprecated
    public long id;

    /** Id de la cellule en haut (ça sert à rien, vaut mieux utilisé {@link Cell#topCell}) */
    public long top;

    /** Id de la cellule du bas (ça sert à rien, vaut mieux utilisé {@link Cell#bottomCell}) */
    public long bottom;

    /** Id de la cellule de gauche (ça sert à rien, vaut mieux utilisé {@link Cell#leftCell}) */
    public long left;

    /** Id de la cellule de droite (ça sert à rien, vaut mieux utilisé {@link Cell#rightCell}) */
    public long right;

    /** Occupant de la cellule */
    public IAInfo occupant;

    /** Item présent sur la cellule */
    public Item item;

    /** Cellule en haut si accessible (null = mur) */
    @JsonIgnore
    public Cell topCell;

    /** Cellule en bas si accessible (null = mur) */
    @JsonIgnore
    public Cell bottomCell;

    /** Cellule de gauche si accessible (null = mur) */
    @JsonIgnore
    public Cell leftCell;

    /** Cellule de droite si accessible (null = mur) */
    @JsonIgnore
    public Cell rightCell;

    /** Je suis sur la cellule */
    @JsonIgnore
    public boolean moi;

    /** L'ennemi est sur la cellule */
    @JsonIgnore
    public boolean ennemi;

    /** Le poulet est sur la cellule */
    @JsonIgnore
    public boolean poulet;

    /** position horizontale de la cellule */
    public int x;

    /** position verticale de la cellule */
    public int y;

    public List<Cell> getNeighboors() {
        List<Cell> result = new ArrayList<Cell>(4);
        if (topCell != null) {
            result.add(topCell);
        }
        if (bottomCell != null) {
            result.add(bottomCell);
        }
        if (leftCell != null) {
            result.add(leftCell);
        }
        if (rightCell != null) {
            result.add(rightCell);
        }
        return result;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Cell)) {
            return false;
        }
        Cell other = (Cell) obj;
        if (x != other.x) {
            return false;
        }
        if (y != other.y) {
            return false;
        }
        return true;
    }

}
