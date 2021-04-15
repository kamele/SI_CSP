package Problem;

import Constrains.*;


public class EinsteinRiddle {

    Node[] AllNodes;

    public EinsteinRiddle() {
        int [] domain ={0,1,2,3,4};

        //color:red, green, yellow, white, blue
        Node red = new Node(domain);
        Node green = new Node(domain);
        Node yellow = new Node(domain);
        Node white = new Node(domain);
        Node blue = new Node(domain);

        //nationality Norweg, Anglik, Dunczyk, Szwed, Niemiec
        Node Norweg = new Node(new int[]{0});
        Node Anglik = new Node(domain);
        Node Dunczyk = new Node(domain);
        Node Szwed = new Node(domain);
        Node Niemiec = new Node(domain);

        //smoke  light, bezFiltra, mentolowe, cygara, fajka
        Node light = new Node(domain);
        Node bezFiltra = new Node(domain);
        Node mentolowe = new Node(domain);
        Node cygara = new Node(domain);
        Node fajka = new Node(domain);

        //drink tea, caffe, beer, milk, water
        Node tea = new Node(domain);
        Node caffe = new Node(domain);
        Node beer = new Node(domain);
        Node milk = new Node(new int[]{2});
        Node water = new Node(domain);

        //animal cat, horse, bird, dog, fish
        Node cat = new Node(domain);
        Node horse = new Node(domain);
        Node bird = new Node(domain);
        Node dog = new Node(domain);
        Node fish = new Node(domain);


        /*
        IConstrain norwegInFirst = new LiveInFirstHouseConstrain(Norweg);
        *//*
        IConstrain anglikInRed = new SameHouseConstrain(Anglik,red);
        IConstrain greenLeftWhite = new LeftNeighborConstrain(green,white);
        IConstrain DunczykAndTea = new SameHouseConstrain(Dunczyk,tea);
        IConstrain lightSideCat = new NeighborConstrain(light,cat);
        IConstrain yellowAndCygara = new SameHouseConstrain(yellow,cygara);
        IConstrain niemiecAndFajka = new SameHouseConstrain(Niemiec,fajka);
        *//*
        IConstrain milkInThird = new LiveInThirdHouseConstrain(milk);
        *//*
        IConstrain lightSideWater = new NeighborConstrain(light,water);
        IConstrain bezFiltraAndBird = new SameHouseConstrain(bezFiltra,bird);
        IConstrain SzwedAndDog = new SameHouseConstrain(Szwed,dog);
        IConstrain NorwegSideBlue = new NeighborConstrain(Norweg,blue);
        IConstrain horseSideYellow = new NeighborConstrain(horse,yellow);
        IConstrain mentoloweAndBeer = new SameHouseConstrain(mentolowe, beer);
        IConstrain greenAndCaffe = new SameHouseConstrain(green,caffe);
        */

        //color: red, green, yellow, white, blue
        IConstrain[] redConstrains={new SameHouseConstrain(red,Anglik),
                new NotSameHouseConstrain(red, green),new NotSameHouseConstrain(red, yellow),
                new NotSameHouseConstrain(red, blue),new NotSameHouseConstrain(red, white)};
        red.setConstrains(redConstrains);

        IConstrain[] greenConstrains={new SameHouseConstrain(green,caffe), new RightNeighborConstrain(green,white),
                new NotSameHouseConstrain(green, red),new NotSameHouseConstrain(green, yellow),
                new NotSameHouseConstrain(green, blue),new NotSameHouseConstrain(green, white)};
        green.setConstrains(greenConstrains);

        IConstrain[] yellowConstrains= {new SameHouseConstrain(yellow,cygara), new NeighborConstrain(yellow,horse),
                new NotSameHouseConstrain(yellow, green),new NotSameHouseConstrain(yellow, red),
                new NotSameHouseConstrain(yellow, blue),new NotSameHouseConstrain(yellow, white)};
        yellow.setConstrains(yellowConstrains);

        IConstrain[] whiteConstrains={ new LeftNeighborConstrain(white,green),
                new NotSameHouseConstrain(white, green),new NotSameHouseConstrain(white, yellow),
                new NotSameHouseConstrain(white, blue),new NotSameHouseConstrain(white, red)};
        white.setConstrains(whiteConstrains);

        IConstrain[] blueConstrains= {new NeighborConstrain(blue,Norweg),
                new NotSameHouseConstrain(blue, green),new NotSameHouseConstrain(blue, yellow),
                new NotSameHouseConstrain(blue, red),new NotSameHouseConstrain(blue, white)};
        blue.setConstrains(blueConstrains);

        //nationality Norweg, Anglik, Dunczyk, Szwed, Niemiec
        IConstrain[] NorwegConstrains={new NeighborConstrain(Norweg,blue),
                new NotSameHouseConstrain(Norweg, Anglik),new NotSameHouseConstrain(Norweg, Dunczyk),
                new NotSameHouseConstrain(Norweg, Szwed),new NotSameHouseConstrain(Norweg, Niemiec)};
        Norweg.setConstrains(NorwegConstrains);

        IConstrain[] AnglikConstrains={new SameHouseConstrain(Anglik,red),
                new NotSameHouseConstrain(Anglik, Norweg),new NotSameHouseConstrain(Anglik, Dunczyk),
                new NotSameHouseConstrain(Anglik, Szwed),new NotSameHouseConstrain(Anglik, Niemiec)};
        Anglik.setConstrains(AnglikConstrains);

        IConstrain[] DunczykConstrains={new SameHouseConstrain(Dunczyk,tea),
                new NotSameHouseConstrain(Dunczyk, Anglik),new NotSameHouseConstrain(Dunczyk, Norweg),
                new NotSameHouseConstrain(Dunczyk, Szwed),new NotSameHouseConstrain(Dunczyk, Niemiec)};
        Dunczyk.setConstrains(DunczykConstrains);

        IConstrain[] SzwedConstrains={new SameHouseConstrain(Szwed,dog),
                new NotSameHouseConstrain(Szwed, Anglik),new NotSameHouseConstrain(Szwed, Dunczyk),
                new NotSameHouseConstrain(Szwed, Norweg),new NotSameHouseConstrain(Szwed, Niemiec)};
        Szwed.setConstrains(SzwedConstrains);

        IConstrain[] NiemiecConstrains={new SameHouseConstrain(Niemiec,fajka),
                new NotSameHouseConstrain(Niemiec, Anglik),new NotSameHouseConstrain(Niemiec, Dunczyk),
                new NotSameHouseConstrain(Niemiec, Szwed),new NotSameHouseConstrain(Niemiec, Norweg)};
        Niemiec.setConstrains(NiemiecConstrains);

        //smoke  light, bezFiltra, mentolowe, cygara, fajka
        IConstrain[] lightConstrains={new NeighborConstrain(light,cat),new NeighborConstrain(light,water),
                new NotSameHouseConstrain(light, bezFiltra),new NotSameHouseConstrain(light, mentolowe),
                new NotSameHouseConstrain(light, cygara),new NotSameHouseConstrain(light, fajka)};
        light.setConstrains(lightConstrains);

        IConstrain[] bezFiltraConstrains={new SameHouseConstrain(bezFiltra,bird),
                new NotSameHouseConstrain(bezFiltra, light),new NotSameHouseConstrain(bezFiltra, mentolowe),
                new NotSameHouseConstrain(bezFiltra, cygara),new NotSameHouseConstrain(bezFiltra, fajka)};
        bezFiltra.setConstrains(bezFiltraConstrains);

        IConstrain[] mentoloweConstrains={new SameHouseConstrain(mentolowe, beer),
                new NotSameHouseConstrain(mentolowe, bezFiltra),new NotSameHouseConstrain(mentolowe, light),
                new NotSameHouseConstrain(mentolowe, cygara),new NotSameHouseConstrain(mentolowe, fajka)};
        mentolowe.setConstrains(mentoloweConstrains);

        IConstrain[] cygaraConstrains={new SameHouseConstrain(cygara,yellow),
                new NotSameHouseConstrain(cygara, bezFiltra),new NotSameHouseConstrain(cygara, mentolowe),
                new NotSameHouseConstrain(cygara, light),new NotSameHouseConstrain(cygara, fajka)};
        cygara.setConstrains(cygaraConstrains);

        IConstrain[] fajkaConstrains={new SameHouseConstrain(fajka,Niemiec),
                new NotSameHouseConstrain(fajka, bezFiltra),new NotSameHouseConstrain(fajka, mentolowe),
                new NotSameHouseConstrain(fajka, cygara),new NotSameHouseConstrain(fajka, light)};
        fajka.setConstrains(fajkaConstrains);

        //drink tea, caffe, beer, milk, water
        IConstrain[] teaConstrains={ new SameHouseConstrain(tea,Dunczyk),
                new NotSameHouseConstrain(tea, caffe),new NotSameHouseConstrain(tea, beer),
                new NotSameHouseConstrain(tea, milk),new NotSameHouseConstrain(tea, water)};
        tea.setConstrains(teaConstrains);

        IConstrain[] caffeConstrains={ new SameHouseConstrain(caffe,green),
                new NotSameHouseConstrain(caffe, tea),new NotSameHouseConstrain(caffe, beer),
                new NotSameHouseConstrain(caffe, milk),new NotSameHouseConstrain(caffe, water)};
        caffe.setConstrains(caffeConstrains);

        IConstrain[] beerConstrains={ new SameHouseConstrain(beer, mentolowe),
                new NotSameHouseConstrain(beer, caffe),new NotSameHouseConstrain(beer, tea),
                new NotSameHouseConstrain(beer, milk),new NotSameHouseConstrain(beer, water)};
        beer.setConstrains(beerConstrains);

        IConstrain[] milkConstrains={
                new NotSameHouseConstrain(milk, caffe),new NotSameHouseConstrain(milk, beer),
                new NotSameHouseConstrain(milk, tea),new NotSameHouseConstrain(milk, water)};
        milk.setConstrains(milkConstrains);

        IConstrain[] waterConstrains={new NeighborConstrain(water,light),
                new NotSameHouseConstrain(water, caffe),new NotSameHouseConstrain(water, beer),
                new NotSameHouseConstrain(water, milk),new NotSameHouseConstrain(water, tea)};
        water.setConstrains(waterConstrains);


        //animal cat, horse, bird, dog, fish
        IConstrain[] catConstrains={new NeighborConstrain(cat,light),
                new NotSameHouseConstrain(cat, horse),new NotSameHouseConstrain(cat, bird),
                new NotSameHouseConstrain(cat, dog),new NotSameHouseConstrain(cat, fish)};
        cat.setConstrains(catConstrains);

        IConstrain[] horseConstrains={ new NeighborConstrain(horse,yellow),
                new NotSameHouseConstrain(horse, cat),new NotSameHouseConstrain(horse, bird),
                new NotSameHouseConstrain(horse, dog),new NotSameHouseConstrain(horse, fish)};
        horse.setConstrains(horseConstrains);

        IConstrain[] birdConstrains={new SameHouseConstrain(bird,bezFiltra),
                new NotSameHouseConstrain(bird, horse),new NotSameHouseConstrain(bird, cat),
                new NotSameHouseConstrain(bird, dog),new NotSameHouseConstrain(bird, fish)};
        bird.setConstrains(birdConstrains);

        IConstrain[] dogConstrains={new SameHouseConstrain(dog,Szwed),
                new NotSameHouseConstrain(dog, horse),new NotSameHouseConstrain(dog, bird),
                new NotSameHouseConstrain(dog, cat),new NotSameHouseConstrain(dog, fish)};
        dog.setConstrains(dogConstrains);

        IConstrain[] fishConstrains={
                new NotSameHouseConstrain(fish, horse),new NotSameHouseConstrain(fish, bird),
                new NotSameHouseConstrain(fish, dog),new NotSameHouseConstrain(fish, cat)};
        fish.setConstrains(fishConstrains);


        this.AllNodes = new Node[] {
                red, green, yellow, white, blue,
                Norweg, Anglik, Dunczyk, Szwed, Niemiec,
                light, bezFiltra, mentolowe, cygara, fajka,
                tea, caffe, beer, milk, water,
                cat, horse, bird, dog, fish

        };
        /*
        System.out.println("Dziedziny - tworzenie");
        for(int i=0; i<AllNodes.length;i++){
            System.out.println("("+i +") --------->"+AllNodes[i].getDomain().length);
        }
         */
    }

    public Node[] getAllNodes() {
        return AllNodes;
    }

}
