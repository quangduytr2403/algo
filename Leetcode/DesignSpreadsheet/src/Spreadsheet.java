class Spreadsheet {
    int[][] sheet;
    int n;

    public Spreadsheet(int rows) {
        n = rows;
        sheet = new int[n + 1][26];
    }

    public void setCell(String cell, int value) {
        sheet[Integer.parseInt(cell.substring(1))][cell.charAt(0) - 'A'] = value;
    }

    public void resetCell(String cell) {
        sheet[Integer.parseInt(cell.substring(1))][cell.charAt(0) - 'A'] = 0;
    }

    public int getValue(String formula) {
        String[] data = formula.substring(1).split("\\+");
        return calcValue(data[0]) + calcValue(data[1]);
    }

    int calcValue(String data) {
        if (data.charAt(0) >= 'A' && data.charAt(0) <= 'Z') {
            int index = Integer.parseInt(data.substring(1));
            return index > n ? 0 : sheet[index][data.charAt(0) - 'A'];
        } else return Integer.parseInt(data);
    }
}