import human.Person;
import human.Personality;

module dalN {
    exports entities;
    exports repositories;
    exports human;

    uses Personality;
    provides human.Personality with Person;

    //uses human.Personality;
    //provides human.Personality with human.Person;
}