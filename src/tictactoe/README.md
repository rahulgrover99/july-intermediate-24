## Revision

1. Class Diagram
   1. Requirements - nouns, attributes.
   2. Imagined the game play/requirements
2. Write all the models.
3. Package structure
   1. MVC. 
   2. Models, Controllers,
   3. Service
   4. Strategies
   5. DTOs.
4. Clients. Public facing APIs.
   1. /startGame 
      1. Request: 
         1. List of players
         2. Board dimensions
         3. Winning Strategies
      2. Response: 
         1. Game (DTO object if needed)
   2. /makeNextMove
      1. Request: Move? 
      2. Response: GameState
   3. /displayBoard
   4. /undoLastMove
   5. /getGameState
   6. /getWinner
5. Builder design pattern - Game
6. Strategy design pattern.