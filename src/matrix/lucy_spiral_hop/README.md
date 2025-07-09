Tilte: Lucy’s Spiral Hop (Anti-Clockwise Skip Spiral)

Lucy starts from cell (0,0) in a 2D matrix and moves in an anti-clockwise spiral pattern,
skipping every alternate cell. The goal is to determine the value of the last cell she hops onto.

Movement pattern:
- Anti-clockwise spiral (left → down → right → up)
- Skip every alternate cell (hop on, skip next, hop on, etc.)

Approach:
- Simulate anti-clockwise spiral traversal
- Maintain a skip flag to alternate between hopping and skipping
- Track visited cells to avoid revisiting
- Record only the hopped cells, return the last one

Time Complexity: O(N * M) — each cell is visited at most once
Space Complexity: O(N * M) for visited tracking
