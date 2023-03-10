public class watch 
{
    private Person person;
    private Movie movie;
    private int rating;

    public watch(Person person, Movie movie, int rating)
    {
        this.person = person;
        this.movie = movie;
        this.rating = rating;
        person.addWatch(this);
        movie.addWatch(this);
    }
}
