package structure;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //

/**
 * POLYMORPHISME SUR LES APPLICATION
 * @author ben
 */
public interface AppAll {
    
    /**
     * AJOUTE UN OBJET
     * OBJECT O SE TRANSFORMERA SOIT EN CONTACT OU PHOTO
     * @param o 
     */
    public abstract void addCI(Object o);

    /**
     * SUPPRIME UN OBJET
     * OBJECT O SE TRANSFORMERA SOIT EN CONTACT OU PHOTO
     * @param o 
     */
    public abstract void deleteCI(Object o);
    
}

