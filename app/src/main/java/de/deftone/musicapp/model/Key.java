package de.deftone.musicapp.model;

import de.deftone.musicapp.R;

public enum Key {
    C {
        @Override
        public KeyData getKeyData() {
            return new KeyData("C-Dur", R.drawable.c_dur, R.drawable.c_dur_penta);
        }
    },
    D {
        @Override
        public KeyData getKeyData() {
            return new KeyData("D-Dur", R.drawable.d_dur, R.drawable.d_dur_penta);
        }
    },
    E {
        @Override
        public KeyData getKeyData() {
            return new KeyData("E-Dur", R.drawable.e_dur, R.drawable.e_dur_penta);
        }
    },
    F {
        @Override
        public KeyData getKeyData() {
            return new KeyData("F-Dur", R.drawable.f_dur, R.drawable.f_dur_penta);
        }
    },
    G {
        @Override
        public KeyData getKeyData() {
            return new KeyData("G-Dur", R.drawable.g_dur, R.drawable.g_dur_penta);
        }
    },
    A {
        @Override
        public KeyData getKeyData() {
            return new KeyData("A-Dur", R.drawable.a_dur, R.drawable.a_dur_penta);
        }
    },
    B {
        @Override
        public KeyData getKeyData() {
            return new KeyData("B-Dur", R.drawable.b_dur, R.drawable.b_dur_penta);
        }
    },
    BB {
        @Override
        public KeyData getKeyData() {
            return new KeyData("Bb-Dur", R.drawable.bb_dur, R.drawable.bb_dur_penta);
        }
    },
    EB {
        @Override
        public KeyData getKeyData() {
            return new KeyData("Eb-Dur", R.drawable.eb_dur, R.drawable.eb_dur_penta);
        }
    },
    AB {
        @Override
        public KeyData getKeyData() {
            return new KeyData("Ab-Dur", R.drawable.ab_dur, R.drawable.ab_dur_penta);
        }
    },
    DB {
        @Override
        public KeyData getKeyData() {
            return new KeyData("Db-Dur", R.drawable.db_dur, R.drawable.db_dur_penta);
        }
    },
    FIS {
        @Override
        public KeyData getKeyData() {
            return new KeyData("F#-Dur", R.drawable.fis_dur, R.drawable.fis_dur_penta);
        }
    };

    public abstract KeyData getKeyData();
}
