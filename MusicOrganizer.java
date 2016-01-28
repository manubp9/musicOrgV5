import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio tracks.
 * Individual tracks may be played.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing music tracks.
    private ArrayList<Track> tracks;
    //Un objeto iterator que recorre toda las canciones de la lista
    private Iterator<Track> iterador; 
    // A player for the music tracks.
    private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;
    //muestra si se esta reproduciendo la cancion
    private boolean isPlaying;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        tracks = new ArrayList<Track>();
        iterador = tracks.iterator();//inicializo el iterador diciendole que se inicie en el arraylist tracks
        player = new MusicPlayer();
        reader = new TrackReader();
        isPlaying = false;
        readLibrary("audio");
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();

    }

    /**
     * invoca un metodo iterador que imprime por pantalla la informacion de las canciones 
     * incluidas en el array list tracks.
     */
    public void listAllTrackWithIterator(){
        while (iterador.hasNext())
        {
            System.out.println (iterador.next().getDetails());
        }
    }

    /**
     * Add a track file to the collection.
     * @param filename The file name of the track to be added.
     */
    public void addFile(String filename)
    {
        tracks.add(new Track(filename));
    }

    /**
     * metodo  que imprime por pantalla la informacion de los tracks 
     */
    public void findInTitle(String TitleSearch){
        for (Track track : tracks){
            String title = track.getTitle();
            if (title.contains(TitleSearch)){
                System.out.println(track.getDetails());
            }
        }

    }

    /**
     * Add a track to the collection.
     * @param track The track to be added.
     */
    public void addTrack(Track track)
    {
        tracks.add(track);
    }

    /**
     * Play a track in the collection.
     * @param index The index of the track to be played.
     */
    public void playTrack(int index)
    {
        if(indexValid(index)) {
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
            tracks.get(index).incrementCount();
            isPlaying = true;
        }
    }

    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }

    /**
     * List a track from the collection.
     * @param index The index of the track to be listed.
     */
    public void listTrack(int index)
    {
        System.out.print("Track " + index + ": ");
        Track track = tracks.get(index);
        System.out.println(track.getDetails());
    }

    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks()
    {
        System.out.println("Track listing: ");

        for(Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }

    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist(String artist)
    {
        for(Track track : tracks) {
            if(track.getArtist().contains(artist)) {
                System.out.println(track.getDetails());
            }
        }
    }

    /**
     * Remove a track from the collection.
     * @param index The index of the track to be removed.
     */
    public void removeTrack(int index)
    {
        if(indexValid(index)) {
            tracks.remove(index);
        }
    }

    public void añadirGenero(int index,String newGenero){
        Track track = tracks.get(index);
        track.addGenero(newGenero);
    }

    /**
     * Play the first track in the collection, if there is one.
     */
    public void playFirst()
    {
        if (isPlaying)
        {
            System.out.println("Ya se esta reproduciendo una cancion");
        }
        else{
            if(tracks.size() > 0) {
                player.startPlaying(tracks.get(0).getFilename());
                tracks.get(0).incrementCount();
                isPlaying = true;
            }
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
        isPlaying = false;
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;

        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }

    private void readLibrary(String folderName)
    {
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");

        // Put all thetracks into the organizer.
        for(Track track : tempTracks) {
            addTrack(track);
        }
    }

    /**
     * Metodo que muestra por pantalla si se estan reproduciendo canciones o no
     */
    public void isPlayingASong(){
        if (isPlaying = false){
            System.out.println("No se esta reproduciendo niguna cancion");
        }
        else{ 
            System.out.println("Ya se esta reproduciendo una cancion");

        }
    }
}
