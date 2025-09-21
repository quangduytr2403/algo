import java.util.*;

class MovieRentingSystem {
    Map<Integer, PriorityQueue<Movie>> unRent= new HashMap<>();
    Map<Long, Movie> m = new HashMap<>();
    PriorityQueue<Movie> rent = new PriorityQueue<>((m1, m2) ->
        m1.price == m2.price ? (m1.shopId == m2.shopId ? m1.movieId - m2.movieId : m1.shopId - m2.shopId) : m1.price - m2.price
    );

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entry : entries) {
            Movie movie = new Movie(entry[0], entry[1], entry[2]);
            if (!unRent.containsKey(movie.movieId)) unRent.put(movie.movieId, new PriorityQueue<>((m1, m2) -> m1.price == m2.price ? m1.shopId - m2.shopId : m1.price - m2.price));
            unRent.get(movie.movieId).add(movie);
            m.put(encode(movie.shopId, movie.movieId), movie);
        }
    }

    private long encode(int shopId, int movieId) {
        return ((long)shopId << 20) | movieId;
    }

    public List<Integer> search(int movie) {
        PriorityQueue<Movie> q = unRent.get(movie);
        if (q == null) return new ArrayList<>();
        List<Movie> res = new ArrayList<>();
        List<Movie> removed = new ArrayList<>();
        while (res.size() < 5 && !q.isEmpty()) {
            Movie tMovie = q.poll();
            removed.add(tMovie);
            if (!tMovie.isRented) {
                res.add(tMovie);
            }
        }
        q.addAll(removed);
        return res.stream().map(m -> m.shopId).toList();
    }

    public void rent(int shop, int movie) {
        Movie tMovie = m.get(encode(shop, movie));
        if (tMovie != null) {
            tMovie.isRented = true;
            rent.add(tMovie);
        }
    }

    public void drop(int shop, int movie) {
        Movie tMovie = m.get(encode(shop, movie));
        if (tMovie != null) {
            tMovie.isRented = false;
        }
    }

    public List<List<Integer>> report() {
        List<Movie> res = new ArrayList<>();
        List<Movie> removed = new ArrayList<>();
        while (res.size() < 5 && !rent.isEmpty()) {
            Movie tMovie = rent.poll();
            if (tMovie.isRented && res.stream().noneMatch(movie -> movie.movieId == tMovie.movieId && movie.shopId == tMovie.shopId)) {
                res.add(tMovie);
                removed.add(tMovie);
            }
        }
        rent.addAll(removed);
        return res.stream().map(movie -> Arrays.asList(movie.shopId, movie.movieId)).toList();
    }
}

class Movie {
    int movieId;
    int shopId;
    int price;
    boolean isRented;

    public Movie(int shopId, int movieId, int price) {
        this.shopId = shopId;
        this.movieId = movieId;
        this.price = price;
        this.isRented = false;
    }
}
