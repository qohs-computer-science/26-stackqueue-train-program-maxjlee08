# Copilot Instructions for Train Station Queue/Stack Program

## Project Overview
This is a train yard management system assignment that processes incoming train cars using Queue and Stack data structures to route them to different tracks based on mileage and destination.

**Core Goal**: Read train car data from `data.txt`, organize cars into tracks using data structures, and simulate train departures.

## Architecture & Key Patterns

### Data Flow
1. **Input Phase**: Parse `data.txt` sequentially (format: CAR####, product, origin, destination, weight, miles)
2. **Initial Queue**: All cars enter `trackStart` (main line/track 0) as a Queue
3. **Processing Rules**:
   - Cars with **>700 miles** → Track 1 (inspection queue)
   - Cars destined for **Trenton** → Track A (weight limit: `limitTrackA`)
   - Cars destined for **Charlotte** → Track B (weight limit: `limitTrackB`)
   - Cars destined for **Baltimore** → Track C (weight limit: `limitTrackC`)
   - Other destinations → Track D (unlimited capacity)

### Critical Implementation Notes
- **Queue vs Stack**: Use `Queue<Train>` (FIFO) for track assignments; use `Stack` for inspection processing if needed
- **Weight Management**: Each track has weight limits (A/B/C: 100,000 units); Track D is unlimited
- **Class Structure**: `Train` class holds car metadata; `MyProgram` handles orchestration and I/O

## Current Code Issues to Address

### Train.java Issues
- Type mismatch: Constructor parameters marked as `string` (lowercase) instead of `String`
- Parameter `miles` passed as `m` (undeclared variable)
- Duplicate `getName()` method
- Return types for getters should return primitive types (int for weight/miles), not String
- Syntax error: `get getMiles()` (extra `get`)

### MyProgram.java Issues
- Incomplete parser: `while` loop exits immediately after reading first line
- Variable naming inconsistency: `x` vs `in` for Scanner
- `linkedList` should be `LinkedList` (capitalization)
- Parsing logic incomplete: weight assignment line is cut off
- Missing logic to route cars to tracks based on rules

## Common Coding Patterns

1. **File I/O Pattern**: Try-catch with Scanner wrapping file path relative to project root
2. **Train Object Creation**: Parse 6 consecutive lines from file as single Train object
3. **Queue Operations**: Use `add()` to enqueue, `poll()`/`peek()` for dequeue
4. **Track Assignment**: Check conditions in priority order (miles > 700 first, then destination)

## Development Workflow

```bash
# Compile (if using command line)
javac HelloWorldProject/src/*.java -d HelloWorldProject/bin/

# Run
java -cp HelloWorldProject/bin/ MyProgram
```

**Note**: This is primarily a data structure assignment focused on correctness of queue/stack usage over OOP complexity.

## Key Files Reference
- [Train.java](HelloWorldProject/src/Train.java) - Train car model class
- [MyProgram.java](HelloWorldProject/src/MyProgram.java) - Main orchestration and I/O
- [data.txt](HelloWorldProject/src/data.txt) - Input car records (ends with "END" marker)
