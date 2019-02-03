package de.deftone.musicapp.model;

import de.deftone.musicapp.R;

public enum KeyData {
    C {
        @Override
        public Key getKeyData() {
            return new Key("C-Dur", R.drawable.c_dur, R.drawable.c_dur_penta);
        }
    },
    D {
        @Override
        public Key getKeyData() {
            return new Key("D-Dur", R.drawable.d_dur, R.drawable.d_dur_penta);
        }
    },
    E {
        @Override
        public Key getKeyData() {
            return new Key("E-Dur", R.drawable.e_dur, R.drawable.e_dur_penta);
        }
    },
    F {
        @Override
        public Key getKeyData() {
            return new Key("F-Dur", R.drawable.f_dur, R.drawable.f_dur_penta);
        }
    },
    G {
        @Override
        public Key getKeyData() {
            return new Key("G-Dur", R.drawable.g_dur, R.drawable.g_dur_penta);
        }
    },
    A {
        @Override
        public Key getKeyData() {
            return new Key("A-Dur", R.drawable.a_dur, R.drawable.a_dur_penta);
        }
    },
    B {
        @Override
        public Key getKeyData() {
            return new Key("B-Dur", R.drawable.b_dur, R.drawable.b_dur_penta);
        }
    },
    BB {
        @Override
        public Key getKeyData() {
            return new Key("Bb-Dur", R.drawable.bb_dur, R.drawable.bb_dur_penta);
        }
    },
    EB {
        @Override
        public Key getKeyData() {
            return new Key("Eb-Dur", R.drawable.eb_dur, R.drawable.eb_dur_penta);
        }
    },
    AB {
        @Override
        public Key getKeyData() {
            return new Key("Ab-Dur", R.drawable.ab_dur, R.drawable.ab_dur_penta);
        }
    },
    DB {
        @Override
        public Key getKeyData() {
            return new Key("Db-Dur", R.drawable.db_dur, R.drawable.db_dur_penta);
        }
    },
    FIS {
        @Override
        public Key getKeyData() {
            return new Key("F#-Dur", R.drawable.fis_dur, R.drawable.fis_dur_penta);
        }
    };

    public abstract Key getKeyData();
}
