import java.util.*;

public class Wordle {
    private static final String[] WORDS = {
        "AUDIO", "ABOUT", "ABOVE", "ABUSE", "ACHED", "ACTOR", "ACUTE",
        "ADMIT", "ADOPT", "ADULT", "AFTER", "AGAIN", "AGENT", "AGREE", "AHEAD",
        "ALARM", "ALBUM", "ALERT", "ALIEN", "ALIGN", "ALIKE", "ALIVE", "ALLOW",
        "ANGEL", "ANGER", "ANGLE", "ANGRY", "APART", "APPLE", "APPLY", "ARENA",
        "ARGUE", "ARISE", "ARRAY", "ARROW", "ASIDE", "ASSET", "AUDIO", "AUDIT",
        "AVOID", "AWAKE", "AWARD", "AWARE", "BADLY", "BAKER", "BASIC", "BEACH",
        "BEGAN", "BEGIN", "BEING", "BELOW", "BENCH", "BILLY", "BIRTH", "BLACK",
        "BLADE", "BLAME", "BLANK", "BLAZE", "BLEAK", "BLEND", "BLIND", "BLOCK",
        "BLOOD", "BLOOM", "BLOWN", "BLUES", "BOARD", "BOAST", "BOBBY", "BOGEY",
        "BONDS", "BONES", "BONUS", "BOOKS", "BOOST", "BOOTH", "BOOTS", "BRAIN",
        "BRAND", "BRASS", "BRAVE", "BREAD", "BREAK", "BREED", "BRICK", "BRIDE",
        "BRIEF", "BRING", "BRINK", "BRISK", "BROAD", "BROKE", "BROOK", "BROOM",
        "BROWN", "BRUNT", "BUILD", "BUILT", "BURST", "BUYER", "CABLE", "CADET",
        "CAMEL", "CAMEO", "CAMPS", "CANAL", "CANDY", "CANOE", "CANTO", "CARDS",
        "CARES", "CARGO", "CAROL", "CARRY", "CARTS", "CARVE", "CASES", "CATCH",
        "CATER", "CAUSE", "CAVES", "CEASE", "CEDAR", "CHAIN", "CHAIR", "CHALK",
        "CHAMP", "CHANT", "CHAOS", "CHARM", "CHARS", "CHART", "CHASE", "CHEAP",
        "CHEAT", "CHECK", "CHEEK", "CHEER", "CHESS", "CHEST", "CHICK", "CHIEF",
        "CHILD", "CHILI", "CHILL", "CHIMP", "CHINA", "CHIPS", "CHIRP", "CHOIR",
        "CHOKE", "CHOPS", "CHOSE", "CHUCK", "CHUNK", "CHURN", "CIDER", "CIGAR",
        "CIVIC", "CIVIL", "CLAIM", "CLAMP", "CLAMS", "CLANG", "CLANK", "CLAPS",
        "CLASH", "CLASP", "CLASS", "CLAWS", "CLAYS", "CLEAN", "CLEAR", "CLEAT",
        "CLERK", "CLICK", "CLIFF", "CLIMB", "CLING", "CLOAK", "CLOCK", "CLONE",
        "CLOSE", "CLOTH", "CLOUD", "CLOUT", "CLOWN", "CLUBS", "CLUES", "CLUMP",
        "COACH", "COAST", "COATS", "COBRA", "COCOA", "CODED", "CODES", "COILS",
        "COINS", "COKED", "COKES", "COLDS", "COLON", "COLOR", "COLTS", "COMIC",
        "COMMA", "CONDO", "CONES", "CORAL", "CORDS", "CORES", "CORGI", "CORNS",
        "CORNY", "CORPS", "COSTS", "COUCH", "COUGH", "COUNT", "COURT", "COVES",
        "COVET", "COWED", "COWER", "CRACK", "CRAFT", "CRAMP", "CRANE", "CRANK",
        "CRAPE", "CRAPS", "CRASH", "CRASS", "CRATE", "CRAVE", "CRAWL", "CRAZE",
        "CRAZY", "CREAK", "CREAM", "CREEK", "CREEP", "CREST", "CREWS", "CRIED",
        "CRIER", "CRIES", "CRIME", "CRIMP", "CROAK", "CROCK", "CROCS", "CROOK",
        "CROPS", "CROSS", "CROUP", "CROWD", "CROWN", "CRUDE", "CRUEL", "CRUMB",
        "CRUSH", "CRUST", "CRYPT", "CUBIC", "CUBIT", "CUFFS", "CULLS", "CUMIN",
        "CUPID", "CURBS", "CURDS", "CURED", "CURER", "CURES", "CURLS", "CURLY",
        "CURRY", "CURSE", "CURVE", "CUSHY", "CUTCH", "CYBER", "CYCLE", "CYNIC",
        "DADDY", "DAILY", "DAIRY", "DAISY", "DALES", "DALLY", "DAMES", "DAMNS",
        "DAMPS", "DANCE", "DANDY", "DARES", "DARKS", "DARTS", "DATED", "DATER",
        "DATES", "DAUBS", "DAUNT", "DAZED", "DEALS", "DEANS", "DEARS", "DELAY",
        "DELTA", "DELVE", "DEMON", "DENSE", "DENTS", "DEPOT", "DEPTH", "DERBY",
        "DETER", "DEUCE", "DIARY", "DICED", "DICER", "DICES", "DICEY", "DICKY",
        "DIETS", "DIGIT", "DIKES", "DILLY", "DIMES", "DIMLY", "DINED", "DINER",
        "DINES", "DINGY", "DINKY", "DINTS", "DIODE", "DISCO", "DISCS", "DITCH",
        "DITTO", "DITTY", "DIVAN", "DIVAS", "DIVED", "DIVER", "DIVES", "DIZZY",
        "DOCKS", "DODGE", "DODOS", "DOEST", "DOFFS", "DOILY", "DOING", "DOLES",
        "DOLLS", "DOLLY", "DOLOR", "DOLTS", "DOMED", "DOMES", "DONOR", "DONUT",
        "DOORS", "DOPED", "DOPER", "DOPES", "DOPEY", "DORKS", "DORKY", "DORMS",
        "DOTAL", "DOTED", "DOTER", "DOTES", "DOUGH", "DOUSE", "DOVES", "DOWDY",
        "DOWEL", "DOWER", "DOWNS", "DOWNY", "DOWRY", "DOWSE", "DOXIE", "DOZED",
        "DOZER", "DOZES", "DRABS", "DRAFT", "DRAGS", "DRAIL", "DRAIN", "DRAKE",
        "DRAMA", "DRAMS", "DRANK", "DRAPE", "DRATS", "DRAWL", "DRAWN", "DRAWS",
        "DRAYS", "DREAD", "DREAM", "DREAR", "DRECK", "DREGS", "DRESS", "DRIED",
        "DRIER", "DRIES", "DRIFT", "DRILL", "DRINK", "DRIVE", "DROIT", "DROLL",
        "DRONE", "DROOL", "DROOP", "DROPS", "DROSS", "DROVE", "DROWN", "DRUBS",
        "DRUGS", "DRUID", "DRUMS", "DRUNK", "DRUPE", "DRYLY", "DUALS", "DUCKS",
        "DUCKY", "DUCTS", "DUDES", "DUELS", "DUETS", "DUFFS", "DUFFY", "DUGAL",
        "DUKES", "DULCI", "DULLS", "DULLY", "DULSE", "DUMBO", "DUMBS", "DUMMY",
        "DUMPS", "DUMPY", "DUNES", "DUNCE", "DUNKS", "DUNKY", "DUNNY", "DUOAN",
        "DUPLE", "DURAN", "DURAL", "DURAS", "DURGA", "DURED", "DURER", "DURES",
        "DURGA", "DURST", "DUSKY", "DUSTS", "DUSTY", "DUTCH", "DUVET", "DWALE",
        "DWALL", "DWARF", "DWELL", "DWELT", "DWICK", "DWELL", "DYERS", "DYING",
        "DYKES", "DYNES", "EAGER", "EAGLE", "EARLY", "EARNED", "EARNS", "EARTH",
        "EASED", "EASEL", "EASES", "EATER", "EAVES", "EBBED", "EBBED", "EBONY",
        "ECLAT", "ECHOS", "EDGED", "EDGER", "EDGES", "EDIFY", "EDITS", "EDUCT",
        "EELED", "EELER", "EELES", "EELLS", "EERIE", "EERY", "EGADS", "EGGAR",
        "EGGED", "EGGER", "EGGES", "EGGEY", "EGGIN", "EGGO", "EGGOS", "EGIS",
        "EGIST", "EGITS", "EGOMA", "EGOMD", "EGON", "EGOMY", "EGONE", "EGONS",
        "EGONY", "EGOTA", "EGOTE", "EGOTI", "EGOTS", "EGOUT", "EGRET", "EGUST",
        "EGUTS", "EGYPS", "EIGHT", "EIKON", "EIKON", "EIJOS", "EINAS", "EINDS",
        "EINED", "EINED", "EINED", "EINED", "EINED", "EINED", "EINED", "EINED",
        "ELAIN", "ELAIS", "ELAKE", "ELAND", "ELATE", "ELATE", "ELATE", "ELATE",
        "ELATE", "ELATE", "ELATE", "ELATE", "ELATE", "ELATE", "ELATE", "ELATE",
        "ELBOW", "ELCHE", "ELDEN", "ELDER", "ELECT", "ELEGY", "ELEMI", "ELEOT",
        "ELEPHS", "ELERS", "ELEUT", "ELEVE", "ELFE", "ELFED", "ELFEN", "ELFER",
        "ELFES", "ELFET", "ELFEY", "ELFFI", "ELFFS", "ELFID", "ELFIE", "ELFIN",
        "ELFIS", "ELFLE", "ELFON", "ELFOS", "ELFOT", "ELFTS", "ELFTY", "ELFUN",
        "ELFUS", "ELFYL", "ELGON", "ELATE", "ELIAS", "ELIBU", "ELIDE", "ELIDE",
        "ELIDE", "ELIDE", "ELIDE", "ELIDE", "ELIDE", "ELIDE", "ELIDE", "ELIDE"
    };

    private String secretWord;
    private int attempts = 6;

    public Wordle() {
        Random random = new Random();
        this.secretWord = WORDS[random.nextInt(WORDS.length)];
    }

    public static void main(String[] args) {
        Wordle game = new Wordle();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== WORDLE ===");
        System.out.println("Guess the 5-letter word in 6 attempts!");

        while (game.attempts > 0) {
            System.out.println("\nAttempts remaining: " + game.attempts);
            System.out.print("Enter a 5-letter word: ");
            String guess = scanner.nextLine().toUpperCase().trim();

            if (guess.length() != 5) {
                System.out.println("Please enter exactly 5 letters!");
                continue;
            }

            if (!guess.matches("[A-Z]+")) {
                System.out.println("Please enter only letters!");
                continue;
            }

            if (guess.equals(game.secretWord)) {
                System.out.println("🎉 Correct! The word was: " + game.secretWord);
                scanner.close();
                return;
            }

            System.out.println(game.getHint(guess));
            game.attempts--;
        }

        System.out.println("\n💔 Game Over! The word was: " + game.secretWord);
        scanner.close();
    }

    private String getHint(String guess) {
        StringBuilder hint = new StringBuilder();
        char[] secretChars = secretWord.toCharArray();
        char[] guessChars = guess.toCharArray();

        for (int i = 0; i < 5; i++) {
            if (guessChars[i] == secretChars[i]) {
                hint.append("🟩 ");
            } else if (secretWord.contains(String.valueOf(guessChars[i]))) {
                hint.append("🟨 ");
            } else {
                hint.append("⬜ ");
            }
        }
        return hint.toString();
    }
}
