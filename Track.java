/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;
    //contador de reproducciones
    private int playCount;
    //tipo de musica
    private String genero;
    
    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    public Track(String artist, String title, String filename)
    {
        setDetails(artist, title, filename);
        playCount = 0;
    }
    
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     */
    public Track(String filename)
    {
        setDetails("unknown", "unknown", filename);
    }
    
    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename()
    {
        return filename;
    }
        
    /**
     * Return details of the track: artist, title and file name.
     * @return The track's details.
     */
    public String getDetails()
    {
        return artist + ": " + title + " genere "+genero+  " file: " + filename + ")"+" play count "+playCount;
    }
    
    /**
     * Set details of the track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    private void setDetails(String artist, String title, String filename)
    {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
    }
    /**
     * resetea el contador 
     */
    public void reseatCount(){    
        playCount = 0;
    }
    /**
     * incrementa el contador de uno en uno
     */
    public void incrementCount(){
    playCount++;
    }
    /**
     * le da el genero a la cancion
     */
    public void addGenero(String genero)
    {
        this.genero = genero;
        
    }
    /**
     * A partir del proyecto de la actividad 0053, añade todo lo que consideres necesario para que exista 
     * un método en la clase MusicOrganizer llamado isPlaying que cuando sea invocado informe por pantalla 
     * de si en este momento se está reproduciendo un track completo o si no (no tengas en cuenta el caso de reproducir samples de tracks).
     * Testea los cambios y luego haz un commit.
     * Modifica la clase MusicOrganizer para que, en el caso de que se este reproduciendo un track completo 
     * en este momento y deseemos reproducir un nuevo track, se muestre un mensaje de error por pantalla informando 
     * de que ya hay una reproducción en curso (hasta ahora ambas canciones sonarían a la vez).
     * Testea los cambios y luego haz un commit. Indica la URL de dicho commit.
     */
    
}
