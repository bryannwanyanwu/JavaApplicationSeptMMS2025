// a) Set the 10 elements of integer array counts to zero
int[] counts = new int[10];
for (int i = 0; i < counts.length; i++) {
    counts[i] = 0;
}
// Or using Arrays class: Arrays.fill(counts, 0);

// b) Add one to each of the 15 elements of integer array bonus
int[] bonus = new int[15];
for (int i = 0; i < bonus.length; i++) {
    bonus[i]++;
}

// c) Display the five values of integer array bestScores in column format
int[] bestScores = {85, 92, 78, 95, 88};
for (int score : bestScores) {
    System.out.println(score);
}