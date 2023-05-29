module bservN {
    requires transitive dalN;

    //exports human;

    //requires dalN;
    requires apiN;

    uses human.Personality;

    exports service to modNew;
}