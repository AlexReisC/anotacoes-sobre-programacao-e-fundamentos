# Builder
Esse padrão permite que você construa diferentes tipos e representações de um objeto usando o mesmo código de construção.

## Problema
Imagine um objeto complexo que necessite de uma inicialização trabalhosa, tendo um construtor com muitos parâmetros. Na maioria dos casos a maioria dos parâmetros não será usada, tornando as chamadas do construtor em algo feio de se ver.

## Solução
O padrão Builder sugere que você extraia o código de construção do objeto para fora de sua própria classe e mova ele para objetos separados chamados *builders*. O padrão organiza a construção de objetos em uma série de etapas. 

Para criar um objeto você executa uma série de etapas em um objeto builder, você chama apenas aquelas etapas que são necessárias para a produção de uma configuração específica de um objeto.

Você pode ir além e extrair uma série de chamadas para as etapas do builder que você usa para construir um produto em uma classe separada chamada diretor. A classe diretor define a ordem na qual executar as etapas de construção, enquanto que o builder provê a implementação dessas etapas.

Ter uma classe diretor em seu programa não é estritamente necessário. Contudo, a classe diretor pode ser um bom lugar para colocar várias rotinas de construção para que você possa reutilizá-las em qualquer lugar do seu programa. Além disso, a classe diretor esconde completamente os detalhes da construção do produto do código cliente.

## Aplicabilidade
- O padrão Builder permite que você construa objetos passo a passo, usando apenas aquelas etapas que você realmente precisa. Após implementar o padrão, você não vai mais precisar amontoar dúzias de parâmetros em seus construtores.
- Use o padrão Builder quando você quer que seu código seja capaz de criar diferentes representações do mesmo produto (por exemplo, casas de pedra e madeira).

## Como implementar
1. Certifique se de que você ppode definir todas as etapas comuns de construção para todas as diferentes representações do produto disponiveís. Do contrario, você não será capaz de implementar.
2. Declare essas etapas na interface builder.
3. Crie uma classe builder concreta para cada representação do produto e implemente suas etapas de construção. Implemente um método para recuperar os resultados da construção. 
4. Pense em uma classe diretor. Ela pode encapsular varias formas de construir um produto usando o mesmo objeto builder.
5. O código cliente cria tanto os objetos do builder como do diretor. Antes da construção começar, o cliente deve passar um objeto builder para o diretor. Geralmente o cliente faz isso apenas uma vez, através de parâmetros do construtor do diretor. O diretor usa o objeto builder em todas as construções futuras. Existe uma alternativa onde o builder é passado diretamente ao método de construção do diretor.
6. O resultado da construção pode ser obtido diretamente do diretor apenas se todos os produtos seguirem a mesma interface. Do contrário o cliente deve obter o resultado do builder.

## Prós e contras
- (v) Você pode construir objetos passo a passo, adiar as etapas de construção ou rodar etapas recursivamente.
- (v) Você pode reutilizar o mesmo código de construção quando construindo várias representações de produtos.
- (v) Princípio de responsabilidade única. Você pode isolar um código de construção complexo da lógica de negócio do produto.
- (x) A complexidade geral do código aumenta uma vez que o padrão exige criar múltiplas classes novas.

## Exemplos de código
Interface do builder comum
```java
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}

```

Builder do carro
```java
public class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
```

Produto do carro
```java
public class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;
    private double fuel = 0;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission,
               TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        if (this.tripComputer != null) {
            this.tripComputer.setCar(this);
        }
        this.gpsNavigator = gpsNavigator;
    }

    public CarType getCarType() {
        return carType;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }
}
```

```java
public enum CarType {
    CITY_CAR, SPORTS_CAR, SUV
}
```

Funcionalidades do produto
```java
\\ implementações das classes Engine, Transmition, TripComputer, GPSNavigator.
...
```

Diretor controla os builders
```java
public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }
}
```

Código cliente
```java
public class Demo {

    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());


        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }

}
```