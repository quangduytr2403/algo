import java.util.*;

class Router {

    int LIMIT;
    List<Package> q = new ArrayList<>();
    Map<Integer, List<Package>> m = new HashMap<>();
    Map<Long, Package> m2 = new HashMap<>();

    public Router(int memoryLimit) {
        LIMIT = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        final long key = encode(source, destination, timestamp);
        if(m2.containsKey(key))
            return false;
        Package p = new Package(source, destination, timestamp);
        if (q.size() == LIMIT) forwardPacket();
        q.add(p);
        if (!m.containsKey(destination)) m.put(destination, new ArrayList<>());
        m.get(destination).add(p);
        m2.put(key, p);
        return true;
    }

    private long encode(final int source, final int destination, final int timestamp) {
        return ((long)source << 40) | ((long)destination << 20) | timestamp;
    }

    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[0];

        Package p = q.remove(0);
        m.get(p.getDestination()).remove(0);
        long key = encode(p.getSource(), p.getDestination(), p.getTimestamp());
        m2.remove(key);
        return new int[]{p.getSource(), p.getDestination(), p.getTimestamp()};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Package> list = m.get(destination);
        if(list == null || list.isEmpty()) return 0;
        int findLeft = findLeft(list, 0, list.size() - 1, startTime);
        int findRight = findRight(list, 0, list.size() - 1, endTime);

        if (findRight == -1 || findLeft == -1) return 0;
        return findRight - findLeft + 1;
    }

    int findLeft (List<Package> list, int l, int r, int t) {
        if (l >= r - 1) {
            for (int i = l; i <= r; i++) {
                if (list.get(i).getTimestamp() >= t) return i;
            }
            return -1;
        }
        int m = (l + r) / 2;
        if (list.get(m).getTimestamp() >= t) return findLeft(list, l, m, t);
        else return findLeft(list, m, r, t);
    }

    int findRight (List<Package> list, int l, int r, int t) {
        if (l >= r - 1) {
            for (int i = r; i >= l; i--) {
                if (list.get(i).getTimestamp() <= t) return i;
            }
            return -1;
        }
        int m = (l + r) / 2;
        if (list.get(m).getTimestamp() <= t) return findRight(list, m, r, t);
        else return findRight(list, l, m, t);
    }
}

class Package {
    private int source;
    private int destination;
    private int timestamp;

    public Package(int source, int destination, int timestamp) {
        this.source = source;
        this.destination = destination;
        this.timestamp = timestamp;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
