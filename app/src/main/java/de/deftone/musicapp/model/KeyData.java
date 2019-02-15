package de.deftone.musicapp.model;

import de.deftone.musicapp.R;

public enum KeyData {
    C {
        @Override
        public Key getKeyData() {
            return new Key("C", "C-Dur", R.drawable.c_dur, R.drawable.c_dur_penta);
        }
    },
    D {
        @Override
        public Key getKeyData() {
            return new Key("D", "D-Dur", R.drawable.d_dur, R.drawable.d_dur_penta);
        }
    },
    E {
        @Override
        public Key getKeyData() {
            return new Key("E", "E-Dur", R.drawable.e_dur, R.drawable.e_dur_penta);
        }
    },
    F {
        @Override
        public Key getKeyData() {
            return new Key("F", "F-Dur", R.drawable.f_dur, R.drawable.f_dur_penta);
        }
    },
    G {
        @Override
        public Key getKeyData() {
            return new Key("G", "G-Dur", R.drawable.g_dur, R.drawable.g_dur_penta);
        }
    },
    A {
        @Override
        public Key getKeyData() {
            return new Key("A", "A-Dur", R.drawable.a_dur, R.drawable.a_dur_penta);
        }
    },
    B {
        @Override
        public Key getKeyData() {
            return new Key("B", "B-Dur", R.drawable.b_dur, R.drawable.b_dur_penta);
        }
    },
    BB {
        @Override
        public Key getKeyData() {
            return new Key("Bb", "Bb-Dur", R.drawable.bb_dur, R.drawable.bb_dur_penta);
        }
    },
    EB {
        @Override
        public Key getKeyData() {
            return new Key("Eb", "Eb-Dur", R.drawable.eb_dur, R.drawable.eb_dur_penta);
        }
    },
    AB {
        @Override
        public Key getKeyData() {
            return new Key("Ab", "Ab-Dur", R.drawable.ab_dur, R.drawable.ab_dur_penta);
        }
    },
    DB {
        @Override
        public Key getKeyData() {
            return new Key("Db", "Db-Dur", R.drawable.db_dur, R.drawable.db_dur_penta);
        }
    },
    FIS {
        @Override
        public Key getKeyData() {
            return new Key("F#", "F#-Dur", R.drawable.fis_dur, R.drawable.fis_dur_penta);
        }
    },
//    DEFAULT is not used in circle of fifth
    DEFAULT{
        @Override
        public Key getKeyData() {
            return null;
        }
    };

    public abstract Key getKeyData();

    @Override
    public String toString() {
        return this.getKeyData().getKey();
    }
}
