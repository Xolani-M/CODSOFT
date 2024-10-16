package task_1_number_game.src;

public enum GameState {
    IN_PROGRESS {
        @Override
        public String toString() {
            return "In Progress";
        }
    },

    WON {
        @Override
        public String toString() {
            return "Won";
        }
    },

    GAME_OVER {
        @Override
        public String toString() {
            return "Game Over";
        }
    };

    @Override
    public abstract String toString();
}