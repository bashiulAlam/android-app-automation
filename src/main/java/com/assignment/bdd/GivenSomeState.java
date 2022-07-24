package com.assignment.bdd;

import com.tngtech.jgiven.Stage;

public class GivenSomeState extends Stage<GivenSomeState> {
    public GivenSomeState someState() {
        return self();
    }
}
