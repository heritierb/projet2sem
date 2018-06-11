package structure;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //

// **** POLYMORPHISME SUR LES APPLICATIONS **** //
public interface AppAll {
    
        // **** AJOUTE UN OBJET **** // OBJECT O SE TRANSFORMERA SOIT EN CONTACT OU PHOTO
    public abstract void addCI(Object o);

    // **** SUPPRIME UN OBJET **** // OBJECT O SE TRANSFORMERA SOIT EN CONTACT OU PHOTO
    public abstract void deleteCI(Object o);
    
}

