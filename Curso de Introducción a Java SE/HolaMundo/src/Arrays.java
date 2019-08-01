public class Arrays {


    public static void main(String[] args) {

        String[] androidVersions = new String[17];
        String days[] = new String[7];

        String[][] cities = new String[4][2];


        int [][][] numbers = new int[2][2][2];
        int [][][][] numbers4 = new int[2][2][2][2];


        androidVersions[0] = "Apple Pie";
        androidVersions[1] = "Nannana Bread";
        androidVersions[2] = "Cupcake";
        androidVersions[3] = "Donut";


        for (int i = 0; i < androidVersions.length ; i++) {
            System.out.println(androidVersions[i]);
        }

        System.out.println();


        cities[0][0] = "España";
        cities[0][1] = "Barcelona";
        cities[1][0] = "Colombia";
        cities[1][1] = "Bogota";
        cities[2][0] = "España";
        cities[2][1] = "Madrid";
        cities[3][0] = "España";
        cities[3][1] = "Alicante";


        System.out.println("Pais || Ciudad");
        for (int row = 0; row < cities.length ; row++) {
            for (int col = 0; col< cities[row].length; col++) {
                System.out.print(cities[row][col]+" ");
            }
            System.out.println();
        }

    }


}
