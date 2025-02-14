class ProductOfNumbers {
    private int[] prefixProduct;
    private int size;

    public ProductOfNumbers() {
        prefixProduct = new int[40001]; // Assuming a reasonable size limit
        size = 0;
    }

    public void add(int num) {
        if (num == 0) {
            size = 0;
        } else {
            int lastProduct = (size == 0) ? 1 : prefixProduct[size - 1];
            prefixProduct[size++] = lastProduct * num;
        }
    }

    public int getProduct(int k) {
        if (k > size) return 0;
        return k == size ? prefixProduct[size - 1] : prefixProduct[size - 1] / prefixProduct[size - 1 - k];
    }
}
