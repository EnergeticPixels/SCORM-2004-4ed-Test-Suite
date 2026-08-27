## Phase 1 Sprint Backlog (Concrete)

Source plan: [plan_modernization_firstblush.md](plan_modernization_firstblush.md)

### Phase 1 Objective
Establish a reproducible legacy baseline and evidence pack so future modernization work can be validated against known-good behavior.

### Sprint Context
- Sprint length: 4 weeks (20 working days)
- Scope focus: Legacy build/runtime reproducibility, baseline artifacts, applet/frameset dependency inventory, and archival environment documentation
- Capacity model: 6 core contributors, 1 part-time advisor
- Sprint slicing convention for this file:
1. Sprint 1A = Weeks 1-2 of the 4-week sprint
1. Sprint 1B = Weeks 3-4 of the 4-week sprint
- Estimation units:
1. Story points (Fibonacci)
1. Engineering effort hours (team total)

### Owners
- Program Manager (PM): Chrisjen Avasarala
- Technical Lead (TL): Josephus Miller
- Java Lead (J-LD): Naomi Nagata
- Web Lead (W-LD): Alex Kamal
- QA Lead (QA): James Holden
- Accessibility Lead (A11Y): Camina Drummer
- Security Lead (SEC): Bobbie Draper
- DevOps/Build Engineer (DEVOPS): Amos Burton
- Product/Conformance SME (SME): Praxidike Meng

### Sprint Backlog
| ID | Backlog Item | Deliverable | Owner | Dependencies | SP | Est. Hours |
|---|---|---|---|---|---:|---:|
| P1-01 | Define baseline test matrix | Approved matrix of representative LMS, SCO, Content Package, and Manifest flows for baseline runs | QA + SME + TL | None | 5 | 14 |
| P1-02 | Legacy environment bootstrap procedure | Step-by-step runbook for setting env vars and launching legacy build/runtime from [README.md](README.md) and [software_development/build.xml](software_development/build.xml) | DEVOPS + J-LD | P1-01 | 5 | 12 |
| P1-03 | Execute clean legacy build baseline | Evidence package showing clean build outputs and logs from baseline environment | J-LD + DEVOPS | P1-02 | 8 | 18 |
| P1-04 | Capture baseline runtime results | Golden runtime artifacts (screenshots, logs, expected pass/fail outcomes) from selected matrix flows in [software_development/TestSuite](software_development/TestSuite) | QA + SME | P1-01, P1-03 | 8 | 20 |
| P1-05 | Inventory applet touchpoints | Catalog of Java applet dependencies with file-level references including [software_development/src/org/adl/logging/LogManagerInterfaceApplet.java](software_development/src/org/adl/logging/LogManagerInterfaceApplet.java) | TL + J-LD | P1-03 | 5 | 12 |
| P1-06 | Inventory frameset and legacy browser patterns | Catalog of frameset, inline handler, and browser-sniffing dependencies in [software_development/TestSuite](software_development/TestSuite) | W-LD + QA | P1-01 | 5 | 12 |
| P1-07 | Baseline artifact schema and storage | Standardized evidence structure and naming convention for logs/screenshots/checksums | QA + PM | P1-04 | 3 | 8 |
| P1-08 | Legacy VM/container archival specification | Documented reproducibility image requirements: OS, browser, JDK/JRE, checksums, install sources, and isolation constraints | DEVOPS + SEC | P1-02, P1-03 | 5 | 12 |
| P1-09 | Reproducibility validation rerun | Independent rerun by secondary engineer validating build/runtime reproducibility and artifact consistency | QA + J-LD | P1-04, P1-07, P1-08 | 5 | 12 |
| P1-10 | Baseline variance and known-issues report | Report of nondeterminism, flaky behavior, and environment-specific deltas with mitigations | TL + QA + DEVOPS | P1-09 | 5 | 12 |
| P1-11 | Phase 2 readiness gate definition | Signed checklist proving Phase 1 outputs are sufficient to start toolchain/dependency migration in Phase 2 | TL + PM + SME | P1-10 | 3 | 8 |
| P1-12 | Stakeholder sign-off and publication | Final review packet and publication of baseline docs to `.planning` and project docs | PM + TL | P1-11 | 2 | 6 |

### Totals
- Total story points: 59
- Total estimated hours: 146
- Recommended sprint load target: 50-53 SP (leave 10-15% buffer for legacy environment surprises)

### Suggested Sprint Slicing
1. Sprint 1A (Weeks 1-2): P1-01, P1-02, P1-03, P1-05, P1-06
1. Sprint 1B (Weeks 3-4): P1-04, P1-07, P1-08, P1-09, P1-10, P1-11, P1-12

### Definition of Done for Phase 1
1. Legacy build is reproducible from a clean environment with documented steps.
1. Baseline runtime matrix is executed and evidence artifacts are stored using a standardized structure.
1. Applet and frameset dependency inventories are complete and reviewed.
1. Reproducibility rerun confirms consistency or documents accepted variance.
1. Phase 2 readiness gate is approved.
1. Stakeholder sign-off is recorded.

### Open Inputs Needed
1. Confirm this The Expanse role mapping is final for this project.
1. Confirm target host strategy for legacy reproducibility image (VM preferred vs container attempt).
1. Confirm artifact retention location and retention period.
1. Confirm legal constraints on redistributing legacy runtime installers.

### GitHub Projects Configuration (Recommended)

Use one GitHub Project and create one GitHub Issue per backlog row (P1-01 through P1-12).

### Suggested Project Fields
- Item ID (text)
- Owner Role (single select: PM, TL, J-LD, W-LD, QA, A11Y, SEC, DEVOPS, SME)
- Story Points (number)
- Estimate Hours (number)
- Remaining Hours (number)
- Blocked (single select: No, Yes)
- Dependency IDs (text)
- Acceptance Criteria (text)
- Evidence Link (text)
- Target Sprint (single select: Sprint 1A (Weeks 1-2), Sprint 1B (Weeks 3-4))

### Use Built-In Fields
- Assignees
- Labels
- Milestone
- Status

### Suggested Labels
- phase:1
- track:baseline
- area:legacy-build
- area:runtime-validation
- area:inventory
- area:security

### Suggested Views
1. Board by Status (To do, In progress, Done)
1. Table by Sprint (group by Target Sprint)
1. Blocked Work View (filter Blocked = Yes)
1. Baseline Evidence View (show Item ID, Evidence Link, Status, Assignees)

### Mapping Rules
1. Issue title format: [P1-XX] Backlog Item name
1. Issue body includes Deliverable, Dependencies, Acceptance Criteria, and Evidence section
1. Assign named owner in Assignees and keep Owner Role field for reporting
1. Use Dependency IDs field to reference upstream item IDs

### Minimal Automation
1. Auto-set Status to In progress when an issue is assigned.
1. Auto-set Status to Done when an issue is closed.
1. Optional: auto-set Blocked = Yes when label blocked is added.

### Companion GitHub Issue Template

Copy this block when creating each issue from P1-01 through P1-12.

Title: [P1-XX] Backlog Item Name

Sections to paste into Issue body:

#### Summary
- Backlog ID: P1-XX
- Sprint: Sprint 1A (Weeks 1-2) or Sprint 1B (Weeks 3-4)
- Owner Role: PM | TL | J-LD | W-LD | QA | A11Y | SEC | DEVOPS | SME
- Story Points: <number>
- Estimate Hours: <number>

#### Deliverable
- <expected output artifact>

#### Dependencies
- <upstream IDs or None>

#### Acceptance Criteria
1. <measurable criterion 1>
1. <measurable criterion 2>
1. <measurable criterion 3>

#### Evidence
- Evidence Link(s): <links to artifacts, logs, screenshots, docs>

#### Risks and Notes
- Risks: <known risks>
- Notes: <implementation notes>

#### GitHub Project Field Values
- Item ID: P1-XX
- Owner Role: <single-select role>
- Story Points: <number>
- Estimate Hours: <number>
- Remaining Hours: <number>
- Blocked: No
- Dependency IDs: <IDs or None>
- Target Sprint: Sprint 1A (Weeks 1-2) or Sprint 1B (Weeks 3-4)

### Filled Example (P1-03)

Title: [P1-03] Execute clean legacy build baseline

#### Summary
- Backlog ID: P1-03
- Sprint: Sprint 1A (Weeks 1-2)
- Owner Role: J-LD
- Story Points: 8
- Estimate Hours: 18

#### Deliverable
- Evidence package showing clean legacy build outputs and logs from a baseline environment.

#### Dependencies
- P1-02

#### Acceptance Criteria
1. Build runs from a clean environment using documented prerequisites and environment variables.
1. Build output and logs are captured and stored in the agreed baseline artifact structure.
1. Re-run on the same environment produces consistent results or captures explicit variance notes.

#### Evidence
- Evidence Link(s): <link to build log>, <link to artifact manifest>, <link to environment metadata>

#### Risks and Notes
- Risks: Legacy dependency or environment drift may cause non-deterministic outcomes.
- Notes: Coordinate with DEVOPS for environment reset before each run.

#### GitHub Project Field Values
- Item ID: P1-03
- Owner Role: J-LD
- Story Points: 8
- Estimate Hours: 18
- Remaining Hours: 18
- Blocked: No
- Dependency IDs: P1-02
- Target Sprint: Sprint 1A (Weeks 1-2)

### Filled Example (P1-06)

Title: [P1-06] Inventory frameset and legacy browser patterns

#### Summary
- Backlog ID: P1-06
- Sprint: Sprint 1A (Weeks 1-2)
- Owner Role: W-LD
- Story Points: 5
- Estimate Hours: 12

#### Deliverable
- Catalog of frameset, inline handler, and browser-sniffing dependencies in [software_development/TestSuite](software_development/TestSuite), including file paths and migration priority.

#### Dependencies
- P1-01

#### Acceptance Criteria
1. Inventory includes all files containing frameset usage and inline event handlers within the TestSuite scope.
1. Inventory includes browser-detection or legacy compatibility script references and a recommended migration priority per finding.
1. Inventory is reviewed by QA and TL and checked into project planning artifacts.

#### Evidence
- Evidence Link(s): <link to inventory document>, <link to search output summary>, <link to review sign-off note>

#### Risks and Notes
- Risks: Legacy patterns may be generated or duplicated across mirrored files, increasing review time.
- Notes: Use consistent tags for finding type (frameset, inline-event, browser-sniff, polyfill).

#### GitHub Project Field Values
- Item ID: P1-06
- Owner Role: W-LD
- Story Points: 5
- Estimate Hours: 12
- Remaining Hours: 12
- Blocked: No
- Dependency IDs: P1-01
- Target Sprint: Sprint 1A (Weeks 1-2)

### Filled Example (P1-11)

Title: [P1-11] Phase 2 readiness gate definition

#### Summary
- Backlog ID: P1-11
- Sprint: Sprint 1B (Weeks 3-4)
- Owner Role: TL
- Story Points: 3
- Estimate Hours: 8

#### Deliverable
- Signed readiness checklist confirming Phase 1 outputs are complete and sufficient to begin Phase 2 toolchain/dependency work.

#### Dependencies
- P1-10

#### Acceptance Criteria
1. Readiness checklist includes required baseline artifacts, reproducibility evidence, known variance report, and open-risk disposition.
1. Checklist is reviewed by TL, PM, and SME with explicit go/no-go decision and rationale.
1. Any deferred issues are captured with owners and target phase for resolution.

#### Evidence
- Evidence Link(s): <link to readiness checklist>, <link to review notes>, <link to formal decision record>

#### Risks and Notes
- Risks: Incomplete evidence may delay Phase 2 start and require additional baseline reruns.
- Notes: Keep the checklist criteria aligned with the Definition of Done section in this file.

#### GitHub Project Field Values
- Item ID: P1-11
- Owner Role: TL
- Story Points: 3
- Estimate Hours: 8
- Remaining Hours: 8
- Blocked: No
- Dependency IDs: P1-10
- Target Sprint: Sprint 1B (Weeks 3-4)

### Quick Conversion Checklist
1. Create 12 issues with titles from the Sprint Backlog table.
1. Paste the companion template into each issue body.
1. Fill role, estimates, dependencies, and acceptance criteria from the table.
1. Assign each issue and set GitHub Project field values.
1. Add evidence links as work artifacts are produced.
